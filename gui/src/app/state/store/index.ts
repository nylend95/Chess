import { createStore, applyMiddleware, Middleware } from 'redux';
import logger from 'redux-logger';
import thunk from "redux-thunk";

import { RootState } from '../../models';
import { rootReducer } from '../reducers';
import { initialRootState } from './initial-state';

import { composeWithDevTools } from 'redux-devtools-extension';

const middlewares: Middleware[] = [];

middlewares.push(thunk);

if (process.env.NODE_ENV === 'development') {
    middlewares.push(logger);
}

//Create initial store
export const store = createStore<RootState>(rootReducer, initialRootState, composeWithDevTools(applyMiddleware(...middlewares)));

export default store;

export * from './initial-state';