// Problem link: https://leetcode.com/problems/keys-and-rooms/description/
// Status: Accepted

void helper(int **rooms, int currentRoomNum, int *visitedRooms, int *roomsColSizes) {
    int i = 0;
    while(i < *(roomsColSizes+currentRoomNum)) {
        int nextRoom = *(*(rooms+currentRoomNum)+i);
        if(*(visitedRooms+nextRoom) == 0) {
            *(visitedRooms+nextRoom) = 1;
            helper(rooms, nextRoom, visitedRooms, roomsColSizes);
        }
        i++;
    }
}

int getRoomsCount(int *visitedRooms, int numOfRooms) {
    int entered = 0;
    for(int i = 0; i < numOfRooms; i++) {
        if(*(visitedRooms+i) == 1) entered++;
    }
    return entered;
}

bool canVisitAllRooms(int **rooms, int roomsRowSize, int *roomsColSizes) {
    int *visitedRooms = (int *) calloc(roomsRowSize, sizeof(int));
    *visitedRooms = 1;
    helper(rooms, 0, visitedRooms, roomsColSizes);
    bool res = getRoomsCount(visitedRooms, roomsRowSize) == roomsRowSize;
    free(visitedRooms);
    return res;
}
