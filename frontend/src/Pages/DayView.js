import React, {useEffect, useState} from "react";
import EventModal from "../components/EventModal";
import TodoList from "../components/TodoList";

const DayView = () => {
    const [isModalOpen, setIsModalOpen] = useState(false);
    const [events, setEvents] = useState([]);
    const[selectedEvent, setSelectedEvent]= useState(null);
    const [timelineHours, setTimelineHours] = useState([]);
    const [startHour, setStartHour] = useState(new Date().getHours());
    const currentDate = new Date();
    const currentHour = currentDate.getHours();
    const openModal = () => {
        setIsModalOpen(true);
    };
    const closeModal = () => {
        setIsModalOpen(false);
        setSelectedEvent(null);
    };
    // save event
    const saveEvent = (newEvent) => {
        if(newEvent && newEvent.title && newEvent.startTime&& newEvent.endTime) {
            setEvents([...events, newEvent]); // add event to the list
            closeModal();
        }else{
            alert("Please enter complete event information")
        }
    };
    // delete event
    const deleteEvent=(indexToDelete)=>{
        setEvents(events.filter((_,index)=>index!== indexToDelete));
    };
    //edit event
    const editEvent=(eventData)=>{
        setSelectedEvent(eventData);
        setIsModalOpen(true);
    }
    const formatDate =(date)=>{
        const options ={weekday:"long", year: "numeric", month:"long",day:"numeric"};
        return date.toLocaleDateString("en-US", options);
    }
    useEffect(() => {
        const initialHours = renderTimeline(startHour, (startHour + 9) % 24);
        setTimelineHours(initialHours);
    }, [startHour]);
    const handleScroll = (e) => {
        const { scrollTop, clientHeight, scrollHeight } = e.target;
        if (scrollTop + clientHeight >= scrollHeight - 10) {
            const nextStartHour = (startHour + 10) % 24;
            setStartHour(nextStartHour);
            const nextHours = renderTimeline(nextStartHour, (nextStartHour + 9) % 24);
            setTimelineHours((prev) => [...prev, ...nextHours]);
        }
    };

    const renderTimeline = (startHour, endHour) => {
        const hours = [];
        if (startHour > endHour) {
            for (let hour = startHour; hour < 24; hour++) hours.push(hour);
            for (let hour = 0; hour <= endHour; hour++) hours.push(hour);
        } else {
            for (let hour = startHour; hour <= endHour; hour++) hours.push(hour);
        }
        return hours;
    };
    const getTimePosition = (time) => {
        const [hours, minutes] = time.split(":").map(Number);
        return ((hours * 60 + minutes) - (startHour * 60));
    };
    return (
        <div style={{ display: "flex", height: "100vh" }}>
            {/* Left hand */}
            <div style={{ flex: 1, padding: "20px", borderRight: "1px solid #ccc" }}>
                {/* show current date */}
                <h2 style={{ marginBottom: "20px" }}>{formatDate(currentDate)}</h2>

                <div style={{ display:"flex",justifyContent:"space-between",marginBottom: "10px"}}>
                    <button
                        onClick={openModal}
                        style={iconButtonStyle}
                        title="Add event" // Show annotations on hover
                    >
                        +
                    </button>
                </div>
                <div style={{ display: "grid", gridTemplateColumns: "100px 1fr",  height: "calc(100vh - 150px)", overflowY: "auto" }}
                    onScroll={(e)=>handleScroll(e)}>
                    {/* timeline */}
                    <div style={timeColumnStyle}>
                        {timelineHours.map((hour)=>(
                         <div key={hour}
                              style={{
                             ...timeBlockStyle,
                             backgroundColor: hour === currentHour ? "#f3e1b2" : "#baf0f6",
                         }}>
                             {`${hour}:00`}
                         </div>)
                         )}
                     </div>

                     {/* Event stream */}
                        <div style={eventColumnStyle}>
                            {events
                                .map((event, index) => {
                                    const eventStartHour = parseInt(event.startTime.split(":")[0], 10);
                                    if (eventStartHour < startHour || eventStartHour >= startHour +10) return null;

                                    const top = getTimePosition(event.startTime);
                                    const height = getTimePosition(event.endTime) - top;

                                return (
                                    <div
                                        key={index}
                                        style={{
                                            ...eventStyle,
                                            top: `${top}px`,
                                            height: `${height}px`,
                                        }}
                                    >
                                        <strong>{event.title}</strong>
                                        <p>{`${event.description} - ${event.location}`}</p>
                                        <p>{`${event.startTime} - ${event.endTime}`}</p>
                                        <div>
                                            <button
                                                onClick={() => editEvent(event)}
                                                style={actionButtonStyle}
                                            >
                                                Edit
                                            </button>
                                            <button
                                                onClick={() => deleteEvent(index)}
                                                style={actionButtonStyle}
                                            >
                                                Delete
                                            </button>
                                        </div>
                                    </div>
                                );
                            })};
                            </div>
                         </div>
                 </div>
            <EventModal
                isOpen={isModalOpen}
                onClose={closeModal}
                onSave={saveEvent}
                eventData={selectedEvent}
            />

            {/* Right hand */}
            <div style={{ flex: 1, padding: "20px" }}>
                {/* Current month calendar */}
                <div style={{ marginBottom: "20px", borderBottom: "1px solid #ccc" }}>
                    <h2>Calender</h2>
                    <div style={{ display: "grid", gridTemplateColumns: "repeat(7, 1fr)", gap: "5px" }}>
                        {[...Array(30).keys()].map((day) => (
                            <div
                                key={day}
                                style={{
                                    padding: "10px",
                                    textAlign: "center",
                                    border: "1px solid #ddd",
                                    borderRadius: "5px",
                                }}
                            >
                                {day + 1}
                            </div>
                        ))}
                    </div>
                </div>

                {/*  todo list */}
                <div style={{ flex: 1, padding: "20px" }}>
                    <TodoList />
                </div>
            </div>
        </div>
    );
};



const timeColumnStyle = {
    position: "sticky",
    top: "0",
    backgroundColor: "white",
    zIndex: 1,
    borderRight: "1px solid #ddd",
    fontSize: "14px",
    textAlign: "right",
};

const timeBlockStyle = {
    height: "60px", // Mỗi giờ chiếm 60px
    borderBottom: "1px solid #f0f0f0",
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
};

const eventColumnStyle = {
    position: "relative",
    height: "1440px", // Một ngày có 1440 phút, mỗi phút tương ứng với 1px
    overflowY: "visible",
};

const eventStyle = {
    position: "absolute",
    left: "10px",
    right: "10px",
    backgroundColor: "#007bff",
    color: "white",
    borderRadius: "5px",
    padding: "5px",
    fontSize: "12px",
    boxShadow: "0px 2px 5px rgba(0, 0, 0, 0.1)",
};

const iconButtonStyle = {
    width: "40px",
    height: "40px",
    borderRadius: "50%",
    backgroundColor: "#FA8072",
    color: "white",
    fontSize: "30px",
    fontWeight: "bold",
    border: "none",
    cursor: "pointer",
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
    boxShadow: "0px 4px 6px rgba(0, 0, 0, 0.1)",
};

const actionButtonStyle = {
    marginLeft: "5px",
    padding: "5px 10px",
    fontSize: "12px",
    cursor: "pointer",
    backgroundColor: "#007bff",
    color: "white",
    border: "none",
    borderRadius: "3px",
};


export default DayView;
