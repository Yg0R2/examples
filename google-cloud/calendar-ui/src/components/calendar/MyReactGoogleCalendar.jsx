import React from "react"
import Calendar from "@ericz1803/react-google-calendar"

// https://fullcalendar.io/docs/google-calendar#:~:text=You%20must%20first%20have%20a%20Google%20Calendar%20API%20Key%3A&text=Once%20in%20the%20project%2C%20go,click%20%E2%80%9CCreate%20new%20Key%E2%80%9D.
const API_KEY = "";
let calendars = [
  {
    calendarId: ""
  },
  // {
  //   calendarId: "YOUR_CALENDAR_ID_2",
  //   color: "#B241D1" //optional, specify color of calendar 2 events
  // }
];

class MyReactGoogleCalendar extends React.Component {

  render() {
    return (
      <div>
        <Calendar
          apiKey={API_KEY}
          calendars={calendars}
          styles={{
            today: {
              backgroundColor: 'lightcyan'
            }
          }}
        />
      </div>
    )
  }

}

export default MyReactGoogleCalendar
