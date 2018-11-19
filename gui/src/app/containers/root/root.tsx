import * as React from 'react';
import { Component, ReactNode } from 'react';
import { connect } from 'react-redux';
import { Route, Switch } from 'react-router';
import { BrowserRouter } from 'react-router-dom';

import { RootState } from '../../models';
import {
    HomeContainer,
    GameContainer
} from '../';

interface ComponentStateProps {
}

interface ComponentDispatchProps {
}


class RootContainer extends Component {

    //BrowserRouter is used to easily manipulate browser history
    //A route is a path to a component
    public render(): ReactNode {
        return (
            <BrowserRouter>
                <Switch>
                    <Route path="/game" exact component={GameContainer} />
                    <Route path="/" exact component={HomeContainer} />
                    <Route component={HomeContainer} />
                </Switch>
            </BrowserRouter>
        );
    }
}

//Properties from redux store
const mapStateToProps = (state: RootState): ComponentStateProps => ({
});

//Functions to dispatch (perform action) action to redux store
const mapDispatchToProps = (dispatch): ComponentDispatchProps => ({
});

//Connects component to redux store. 
const ConnectedRootContainer = connect(mapStateToProps, mapDispatchToProps)(RootContainer);

export { ConnectedRootContainer as RootContainer };