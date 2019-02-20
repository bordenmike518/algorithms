#include <iostream>

using namespace std;

#define Threads 3
#define Blocks  4
#define N Threads*Blocks

__global__  // GPU function
void add(int *a, int *b, int n)
{
    // Get ID of thread being executed
	int tid = threadIdx.x + blockIdx.x * blockDim.x;
	// if the thread id is less than the number of loops required
	if (tid < n)
	    // Add them together
		b[tid] += a[tid];
	// Notice there is no return statement
}

int main(void)
{
    // Calculate memory size
	int memSize = N*sizeof(int);

    // Initialize host (CPU) memory
	int *h_a, *h_b;
	h_a = (int*)malloc(memSize);
	h_b = (int*)malloc(memSize);

    // Initialize device (GPU) memory
	int *d_a, *d_b;
	cudaMalloc((void**)&d_a, memSize);
	cudaMalloc((void**)&d_b, memSize);

    // Add some values to host arrays a and b to sum.
	for (int i = 0; i < N; i++) {
		h_a[i] = i;
		h_b[i] = i*i;
	}

    // Send host (CPU) memory to device (GPU)
	cudaMemcpy(d_a, h_a, memSize, cudaMemcpyHostToDevice);
	cudaMemcpy(d_b, h_b, memSize, cudaMemcpyHostToDevice);

    // Run function add() on device (GPU)
	add<<<Blocks, Threads>>>(d_a, d_b, N);

    // Make sure all threads on GPU finish
	cudaThreadSynchronize();

    // Send device (GPU) memory back to host(CPU)
	cudaMemcpy(h_b, d_b, memSize, cudaMemcpyDeviceToHost);

    // Print output from device (GPU)
	for (int i = 0; i < N; i++)
		cout << h_b[i] << "\n";

	// Free host (CPU) memory
	free(h_a);
	free(h_b);
	
	// Free device (GPU) memory
	cudaFree(d_a);
	cudaFree(d_b);

    // Exit with success!
	return 1;
}

