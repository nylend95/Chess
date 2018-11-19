import axios from 'axios';

import { 
    Game,
    NewGameLoadingAction,
    NewGameSuccessAction,
    NewGameErrorAction
 } from "app/models";
import { NewGameActionTypes } from "app/models/constants";


//Declearing outcomes of an action
const newGameLoading = (loading: boolean): NewGameLoadingAction => ({ type: NewGameActionTypes.LOADING, loading });
const newGameSuccess = (payload: Game): NewGameSuccessAction => ({ type: NewGameActionTypes.SUCCESS, payload });
const newGameError = (error: any): NewGameErrorAction => ({ type: NewGameActionTypes.ERROR, error });

const newGamePath = 'api/game/new' //TODO: Change

//One action that dispatches some data to a reducer, effectivly updating the redux store
export function getGame() {
    return (dispatch) => {
        dispatch(newGameLoading(true));
        const url = `${newGamePath}`;
        return axios.get(url)
            .then((response) => {
                return dispatch(newGameSuccess(response.data));
            })
            .catch((error) => {
                return dispatch(newGameError(error));
            });
    };
}