import React, {useState} from "react";
import DayView from "./DayView";
import WeekView from "./WeekView";
import MonthView from "./MonthView";
import NavigationBar from "/Users/lynguyenhansen/Documents/GitHub/project_02148/frontend/src/components/NavigationBar";

const MainPage = () => {
    const [view, setView] = useState("day");
    const [showList, setShowList] = useState("");

    const [events, setEvents] = useState([]);
    const [tasks, setTasks] = useState([]);
    // const events = [
    //     {id: 1, title: "Meeting with John", time: "2025-01-23 10:00"},
    //     {id: 2, title: "Project deadline", time: "2025-01-24 15:00"},
    // ];
    // const tasks = [
    //     {id: 1, title: "Finish report", time: "2025-01-23 12:00"},
    //     {id: 2, title: "Prepare presentation", time: "2025-01-24 09:00"},
    // ];

    //Function to handle mouse leaving list event
    const handleMouseLeave = () => {
        setShowList(""); //Return to default state
    };
    return (
        <div style={{display: "flex", height: "100vh"}}>
            {/* NavigationBar */}
            <div style={{flex: "0 0 10%"}}>
                <NavigationBar
                    onEventsClick={() => setShowList("events")}
                    onTasksClick={() => setShowList("tasks")}
                />
            </div>

            {/* Main content */}
            <div style={{flex: "1", padding: "20px", overflow: "auto"}}>
                {/* Display a list of Events or Tasks */}
                {showList && (
                    <div
                        onMouseLeave={handleMouseLeave}
                        style={{
                            maxHeight: "400px",
                            overflowY: "auto",
                            border: "1px solid #ccc",
                            padding: "20px",
                            backgroundColor: "#f9f9f9",
                        }}
                    >
                        <h2>{showList === "events" ? "Events" : "Tasks"}</h2>
                        <ul>
                            {(showList === "events" ? events : tasks).map((item) => (
                                <li key={item.id}>
                                    <strong>{item.title}</strong> - {item.time}
                                </li>
                            ))}
                        </ul>
                    </div>
                )}


                {/* Show Day/Week/Month view */}
                {!showList && (
                    <>
                    <div>
                        {/* Thanh chọn chế độ hiển thị */}
                        <div style={{display: "flex", justifyContent: "center", marginBottom: "20px"}}>
                            <button onClick={() => setView("day")} style={{...buttonStyle, backgroundColor: "#F1ACB3"}}>
                                Day
                            </button>
                            <button onClick={() => setView("week")}
                                    style={{...buttonStyle, backgroundColor: "#7fd7fa"}}>
                                Week
                            </button>
                            <button onClick={() => setView("month")}
                                    style={{...buttonStyle, backgroundColor: "#fac37f"}}>
                                Month
                            </button>
                        </div>
                        <div style={{ height: "100%", overflowY: "auto" }}>
                            {view === "day" && <DayView/>}
                            {view === "week" && <WeekView/>}
                            {view === "month" && <MonthView/>}
                        </div>
                    </div>
                    </>

                    )}
                    </div>
        </div>
    );
};
const buttonStyle = {
    padding: "10px 20px",
    margin: "0 10px",
    backgroundColor: "#007bff",
    color: "#fff",
    border: "none",
    borderRadius: "5px",
    cursor: "pointer",
};

                export default MainPage;
