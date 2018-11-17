export interface Game {

}

export interface GameState {
    history?: History[];
}

export interface History {
    moveNumber: number,
    whiteMove: Move,
    blackMove: Move
}

export interface Move {
    //TODO: Create move (i.e.  e4, Qd2, Rad1, Rd1, Nf6...)
}


//export interface Game...Action{...}