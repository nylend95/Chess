import * as React from 'react';
import { Component, ReactNode, SFC } from 'react';
import { connect } from 'react-redux';

import { RootState } from '../../models';
import { Redirect } from 'react-router';
import { Button, Segment } from 'semantic-ui-react';

interface ComponentStateProps {
}

interface ComponentDispatchProps {
}

type ComponentProps = ComponentDispatchProps & ComponentStateProps;

interface ComponentState {
    newGame: boolean
}

const initialState: ComponentState = {
    newGame: false
};

class HomeContainer extends Component<ComponentProps, ComponentState> {

    constructor(props: ComponentProps) {
        super(props);
        this.state = initialState;
    }

    public render(): ReactNode {
        const { newGame } = this.state

        if (newGame){
            return <Redirect to="/game" />
        }else {    
            return(
                <HomeScreen 
                    onNewGameButtonClick={this.onNewGameButtonClick} />
            )
        }
    }

    private onNewGameButtonClick(){
        this.setState({ newGame: true })
    }

}

interface HomeScreenProps {
    onNewGameButtonClick: () => void;
}

const HomeScreen: SFC<HomeScreenProps> = (props) => {
    const { onNewGameButtonClick } = props;
    return (
        <Segment>
            <h1>Want to play a game of chess?</h1>
            <Button onClick={onNewGameButtonClick}>New Game</Button>
        </Segment>
    )
}


const mapStateToProps = (state: RootState): ComponentStateProps => ({
});

const mapDispatchToProps = (dispatch): ComponentDispatchProps => ({
});

const ConnectedHomeContainer = connect(mapStateToProps, mapDispatchToProps)(HomeContainer);

export { ConnectedHomeContainer as HomeContainer };