<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Result</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap');

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
        }

        body {
            display: flex;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
            padding: 0 10px;
            background: #675AFE;
        }

        ::selection {
            color: #fff;
            background: #675AFE;
        }

        .result-container {
            width: 370px;
            padding: 30px;
            border-radius: 7px;
            background: #fff;
            box-shadow: 7px 7px 20px rgba(0, 0, 0, 0.05);
        }

        .result-container title {
            font-size: 28px;
            font-weight: 500;
            text-align: center;
        }

        p {
            font-size: 18px;
            margin-bottom: 5px;
        }

        .button {
            display: flex;
            justify-content: center;
            align-items: center;
            margin-top: 15px;
            height: 52px;
            color: #fff;
            font-size: 17px;
            cursor: pointer;
            background: #675AFE;
            transition: 0.3s ease;
        }

        .button:hover {
            background: #4534fe;
        }

        a{
            text-decoration: none;
            color: white;
        }
        a:hover{
            color: #b6b1f2;
        }
    </style>
</head>

<body>
    <%
	HttpSession session2 = request.getSession();
	String n = (String) session.getAttribute("convertedAmount");
	%>
    <div class="result-container">
        <div class="title">
            <h1>Conversion Result</h1>
        </div>
        <div class="details">
            <p>Converted Amount: <%=n %>
            </p>
        </div>
        <div class="button">
            <a href="index.jsp">Convert Another Amount</a>
        </div>
    </div>
</body>

</html>