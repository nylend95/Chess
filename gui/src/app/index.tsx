import * as React from 'react';
import { render } from 'react-dom';

import 'semantic-ui-css/semantic.min.css';
import './index.css';

import { App } from './app'

render(
    <App />,
    document.getElementById('root'),
);