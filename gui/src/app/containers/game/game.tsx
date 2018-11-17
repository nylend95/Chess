import * as React from 'react';
import { Component, ReactNode, SFC } from 'react';
import { connect } from 'react-redux';

import { RootState } from '../../models';
import { Redirect } from 'react-router';
import { Segment } from 'semantic-ui-react';

import { GameState } from '../../models/types';

interface ComponentStateProps {
    gameState: GameState
}

interface ComponentDispatchProps {
}

type ComponentProps = ComponentDispatchProps & ComponentStateProps;

interface ComponentState {
    isAnalysis: boolean
}

const initialState: ComponentState = {
    isAnalysis: false
};

class GameContainer extends Component<ComponentProps, ComponentState> {

    constructor(props: ComponentProps) {
        super(props);
        this.state = initialState;
    }

    public render(): ReactNode {
        const { isAnalysis } = this.state

        if (isAnalysis){
            return <Redirect to="/analysis" />
        }else {    
            return(
                <GameFragment />
            )
        }
    }


}

interface GameFragmentProps {
}

const GameFragment: SFC<GameFragmentProps> = (props) => {
    return (
        <Segment vertical>
            <h1>Game</h1>
            <Segment vertical>

            </Segment>
        </Segment>
    )
}


const mapStateToProps = (state: RootState): ComponentStateProps => ({
    gameState: state.gameState 
});

const mapDispatchToProps = (dispatch): ComponentDispatchProps => ({
});

const ConnectedGameContainer = connect(mapStateToProps, mapDispatchToProps)(GameContainer);

export { ConnectedGameContainer as GameContainer };