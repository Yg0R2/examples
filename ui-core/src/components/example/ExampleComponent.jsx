import React from 'react'

export default class ExampleComponent extends React.Component {
  constructor(props) {
    super(props)

    this.state = {
      text: props.text || 'World'
    }
  }

  render() {
    return (
      <div className='test'>
        Hello {this.state.text} from Example Component!
      </div>
    )
  }
}
