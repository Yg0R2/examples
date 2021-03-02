import Core from '@yg0r2/ui-core'

import React from 'react'

export default class App extends React.Component {
  render() {
    return (
      <div>
        <Core.ExampleComponent text={this.props.userName} />

        <ul>
          <li>
            <a href='/'>Home</a>
          </li>
          <li>
            <a href='/auth/sign-in'>Sign-in</a>
          </li>
          <li>
            <a href='/other'>Other</a>
          </li>
          <li>
            <a href='/backend/api/dummy'>Dummy Service</a>
          </li>
          <li>
            <a href='/auth/api/logout'>Logout</a>
          </li>
        </ul>
      </div>
    )
  }
}
