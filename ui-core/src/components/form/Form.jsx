import React from 'react'

export default class Form extends React.Component {
  constructor(props) {
    super(props)

    this.state = {
      fields: props.fields
    }
  }

  render() {
    const fieldElements = []
    for (const key of Object.keys(this.state.fields)) {
      const field = this.state.fields[key]

      fieldElements.push(
        <div>
          <label>{field.label}</label>
          <input id={key} key={key} {...field.props} />
        </div>
      )
    }

    return (
      <form className={this.props.className}>
        {fieldElements}
        <button onClick={(event) => this.props.submitHandler(event)}>
          {this.props.buttonText}
        </button>
      </form>
    )
  }
}
