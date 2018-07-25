// Problem link: https://leetcode.com/problems/lonely-pixel-i/description/
// Status: Accepted

int findLonelyPixel(char** picture, int pictureRowSize, int pictureColSize) {
    int* rows = (int*) calloc(sizeof(int), pictureRowSize);
    int* cols = (int*) calloc(sizeof(int), pictureColSize);
    for(int i = 0; i < pictureRowSize; i++) {
        for(int j = 0; j < pictureColSize; j++) {
            if(picture[i][j] == 'B') {
                *(rows+i) = *(rows+i) + 1;
                *(cols+j) = *(cols+j) + 1;
            }
        }
    }
    int result = 0;
    for(int i = 0; i < pictureRowSize; i++) {
        for(int j = 0; j < pictureColSize; j++) {
            if(picture[i][j] == 'B' && *(rows+i) == 1 && *(cols+j) == 1) result++;
        }
    }
    return result;
}
