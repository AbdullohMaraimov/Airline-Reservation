<!DOCTYPE html>
<html>
<head>
    <title>Flight Notification</title>
</head>
<body>
<h2>Flight Notification</h2>
<p>Hello,</p>
<p>This email is to inform you about your upcoming flight:</p>

<table border="1">
    <tr>
        <th>From City</th>
        <th>Destination</th>
        <th>Ticket Price</th>
        <th>Date</th>

    </tr>
    <tr>
        <td>${flight.fromCity}</td>
        <td>${flight.destination}</td>
        <td>${flight.ticketPrice}</td>
        <td>${flight.localDateTime}</td>
    </tr>
</table>

<p>Thank you for choosing our service.</p>
</body>
</html>
