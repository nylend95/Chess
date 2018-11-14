import { Component, ReactNode } from 'react';
import * as React from 'react';

import 'semantic-ui-css/semantic.min.css';
import './index.css';
import store from './state/store';
import { Provider } from 'react-redux';

import { RootContainer } from './containers';
import { ErrorHandlerProvider } from './providers';

class App extends Component {

    constructor(props) {
        super(props);
    }

    public render(): ReactNode {
        return (
            <Provider store={store} >
                <ErrorHandlerProvider>
                    <RootContainer />
                </ErrorHandlerProvider>
            </Provider>
        );
    }
}

export { App };