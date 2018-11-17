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

const mapStateToProps = (state: RootState): ComponentStateProps => ({
});

const mapDispatchToProps = (dispatch): ComponentDispatchProps => ({
});

const ConnectedRootContainer = connect(mapStateToProps, mapDispatchToProps)(RootContainer);

export { ConnectedRootContainer as RootContainer };