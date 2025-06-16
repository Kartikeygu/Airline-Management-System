-- Create the database (optional)
CREATE DATABASE IF NOT EXISTS AirlineDB;
USE AirlineDB;

-- Create the Flights table
CREATE TABLE Flights (
    flight_number VARCHAR(10) PRIMARY KEY,
    destination VARCHAR(100) NOT NULL,
    seats_available INT NOT NULL CHECK (seats_available >= 0)
);

-- Insert sample flight data
INSERT INTO Flights (flight_number, destination, seats_available)
VALUES 
('AI101', 'Delhi', 120),
('BA202', 'London', 85),
('EK303', 'Dubai', 150);

-- Select all flights
SELECT * FROM Flights;

-- Book a ticket (decrease seats by 1 for a specific flight)
UPDATE Flights
SET seats_available = seats_available - 1
WHERE flight_number = 'AI101' AND seats_available > 0;

-- Check if seat booking was successful
SELECT * FROM Flights WHERE flight_number = 'AI101';
