// Problem link: https://leetcode.com/problems/spiral-matrix-ii/description/
// Status: Accepted

/**
 * Return an array of arrays.
 * Note: The returned array must be malloced, assume caller calls free().
 */
int** generateMatrix(int n) {
    int** arrays = (int **) calloc(n, sizeof(int*));
    for(int i = 0; i < n; i++) *(arrays+i) = (int *) calloc(n, sizeof(int));
    int numOfEle = n * n, i = 0, j = 0, d = 0;
    char* directions = "rdlu";
    for(int k = 1; k <= numOfEle; k++) {
        if(j < n && *(*(arrays+i)+j) == 0 && *(directions+d) == 'r') {
            *(*(arrays+i)+j) = k;
            j++;
            if(j == n || *(*(arrays+i)+j) != 0) {
                j--;
                i++;
                d = (d+1) % 4;
            }
        } else if(i < n && *(*(arrays+i)+j) == 0 && *(directions+d) == 'd') {
            *(*(arrays+i)+j) = k;
            i++;
            if(i == n || *(*(arrays+i)+j) != 0) {
                i--;
                j--;
                d = (d+1) % 4;
            }
        } else if(j >= 0 && *(*(arrays+i)+j) == 0 && *(directions+d) == 'l') {
            *(*(arrays+i)+j) = k;
            j--;
            if(j == -1 || *(*(arrays+i)+j) != 0) {
                j++;
                i--;
                d = (d+1) % 4;
            }
        } else if(i >= 0 && *(*(arrays+i)+j) == 0 && *(directions+d) == 'u') {
            *(*(arrays+i)+j) = k;
            i--;
            if(i == -1 || *(*(arrays+i)+j) != 0) {
                i++;
                j++;
                d = (d+1) % 4;
            }
        }
    }
    return arrays;
}
