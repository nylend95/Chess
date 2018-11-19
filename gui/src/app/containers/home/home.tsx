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

//Properties from redux-store
type ComponentProps = ComponentDispatchProps & ComponentStateProps;

//Component local state
interface ComponentState {
    newGame: boolean
}

//Initializing local state
const initialState: ComponentState = {
    newGame: false
};

//The class
class HomeContainer extends Component<ComponentProps, ComponentState> {

    constructor(props: ComponentProps) {
        super(props);
        this.state = initialState; //Adding redux state to local state
    }

    public render(): ReactNode {
        const { newGame } = this.state

        if (newGame){
            return <Redirect push to="/game" />
        }else {    
            return(
                <HomeScreen 
                    onNewGameButtonClick={this.onNewGameButtonClick} />
            )
        }
    }

    private onNewGameButtonClick = () => {
        this.setState({ newGame: true })
    }

}

//Properties to helper component
interface HomeScreenProps {
    onNewGameButtonClick: () => void;
}

//Helper component - used to split up code to more managable components
const HomeScreen: SFC<HomeScreenProps> = (props) => {
    const { onNewGameButtonClick } = props;
    return (
        <Segment>
            <h1>Want to play a game of chess?</h1>
            <Button onClick={onNewGameButtonClick}>New Game</Button>
        </Segment>
    )
}


//Properties from redux store
const mapStateToProps = (state: RootState): ComponentStateProps => ({
});

//Functions to dispatch (perform action) action to redux store
const mapDispatchToProps = (dispatch): ComponentDispatchProps => ({
});

//Connects component to redux store. 
const ConnectedHomeContainer = connect(mapStateToProps, mapDispatchToProps)(HomeContainer);

export { ConnectedHomeContainer as HomeContainer };