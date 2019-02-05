#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define lt(a, b) ((a < b) ? a : b)

void cache2dArray(int ***m, int x, int y);
int levensteinDistance(char *s1, char *s2);

int main(int argc, char **argv) {

    if (argc != 3) { 
        printf("Requires 2 strings as argments.\n");
        exit(1);
    }

    char *S1 = argv[1];
    char *S2 = argv[2];

    int dist = levensteinDistance(S1, S2);
    
    printf("Distance between %s and %s is %d.\n", S1, S2, dist);

    return 0;
}

void cache2dArray(int ***m, int rows, int columns) {
    *m = (int**)malloc(rows * sizeof(int*));
    if (m == NULL)
        {printf("ERROR : malloc"); exit(1);     /* ERROR */}
    for(int i = 0; i < rows; i++) {
        (*m)[i] = (int*)malloc(columns * sizeof(int));
        if (m[i] == NULL)
            {printf("ERROR : malloc"); exit(2);  /* ERROR */}
    }
}

int levensteinDistance(char *s1, char *s2) {
    int a=0, b=0, c=0, **m, x, y, answer;
    int i = strlen(s1)+1;
    int j = strlen(s2)+1;
    cache2dArray(&m, i, j);
    for(x = 1; x < i; x++)
        m[x][0] = x;
    for(y = 1; y < j; y++)
        m[0][y] = y;
    for(x = 1; x < i; x++) {
        for(y = 1; y < j; y++) {
            if (s1[x-1] == s2[y-1])
                a = m[x-1][y-1];
            else
                a = m[x-1][y-1] + 1;
            b = m[x-1][y] + 1;
            c = m[x][y-1] + 1;
            m[x][y] = lt(a, lt(b, c));
        }
    }
    answer = m[i-1][j-1];
    free(m);
    return answer;
}
