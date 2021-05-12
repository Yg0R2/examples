import React from 'react'
import {Calendar, momentLocalizer, Views} from 'react-big-calendar'
import moment from 'moment'

import 'react-big-calendar/lib/css/react-big-calendar.css'
import styles from './MyBigCalendar.module.css'

class MyBigCalendar extends React.Component {
  state = {
    events: [
      // {
      //   title: 'Event Title',
      //   start: moment().toDate(),
      //   end: moment().add(1, 'days').toDate(),
      //   allDay: false,
      //   resource: 'any',
      //   selectable: true
      // },
      {
        title: 'Event Title 2',
        start: moment({y: 2021, M: 4, d: 9, h: 16, m: 0}).toDate(),
        end: moment({y: 2021, M: 4, d: 9, h: 17, m: 0}).toDate(),
        allDay: false,
        selectable: true
      }

    ],
    // WTF??
    backgroundEvents: [
      {
        start: moment().add(3, 'days').toDate(),
        end: moment().add(4, 'days').toDate()
      }
    ]
  }

  onDrillDown = (event) => {
    console.log('onDrillDown', event)
  }

  onSelectSlot = (event) => {
    console.log('onSelectSlot', event)
  }

  onSelectEvent = (event) => {
    console.log('onSelectEvent', event)
  }

  componentDidMount() {
    console.log(moment({y: 2021, M: 4, d: 9, h: 16, m: 0}).toDate())
  }

  render() {
    return (
      <div className={styles.calendarWrapper}>
        <Calendar
          localizer={momentLocalizer(moment)}
          events={this.state.events}
          backgroundEvents={this.state.backgroundEvents}
          startAccessor="start"
          endAccessor="end"
          style={{height: 500}}
          views={[Views.MONTH]}
          // titleAccessor='wtf is titleAccessor??'
          // tooltipAccessor='wtf is tooltipAccessor?'
          // allDayAccessor={false}

          onSelectEvent={this.onSelectEvent} // Clock on an event

          onDrillDown={this.onDrillDown} // Click on the date number itself...

          selectable={true}
          onSelectSlot={this.onSelectSlot} // Click on a slot
        />
      </div>
    )
  }
}

export default MyBigCalendar
