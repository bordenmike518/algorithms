def staircasePermCount(N, K):
    if (N in {0,1}):
        return 1
    if (N < K):
        return staircasePermCount(N, N);
    if (N >= K):
        permCount = 0
        for i in range(1, K+1):
            permCount += staircasePermCount(N-i, K)
    return permCount
    
def main():
    print(staircasePermCount(5, 2))

if __name__ == '__main__':
    main()
