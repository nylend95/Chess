import {
    RootState, GameState, Game
} from '../../models';


//Initializing State (redux-store)
export const initialGameState: GameState = {
    loading: false,
    game: {} as Game
}




export const initialRootState: RootState = {
    gameState: initialGameState
};