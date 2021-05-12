import React from 'react'
import Calendar from "react-calendar";

import 'react-calendar/dist/Calendar.css'

class MyCalendar extends React.Component {
  onClickDay = (event) => {
    console.log('onClickDay', event)
  }

  render() {
    return (
      <div>
        <Calendar
          locale='hu-HU'

          maxDetail='month'
          minDetail='month'

          prev2Label={null}
          next2Label={null}

          value={new Date()}
          view='month'

          onClickDay={this.onClickDay}

          // tileContent={'wtf??'}
        />
      </div>
    )
  }
}

export default MyCalendar
