package com.currency.currencyconverter;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@WebServlet("/convert")
public class CurrencyConverter extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String amount = request.getParameter("amount");
		System.out.println(amount);
		String fromCurrency = request.getParameter("fromCurrency");
		String toCurrency = request.getParameter("toCurrency");
//		Scanner sc = new Scanner(System.in);
//		String amount = sc.next();
//		String fromCurrency = sc.next();
//		String toCurrency = sc.next();
		long lAmount = Long.parseLong(amount);
		BigDecimal quantity = BigDecimal.valueOf(lAmount);
		System.out.println();

		OkHttpClient client = new OkHttpClient();

		Request requestOK = new Request.Builder()
				.url("https://api.currencyfreaks.com/v2.0/rates/latest?apikey=504113ca926c44e6afec576e3ffd5d19&base="
						+ fromCurrency.toUpperCase())
				.build();

		Response responseOK = client.newCall(requestOK).execute();
		String stringResponse = responseOK.body().string();
		System.out.println("Raw JSON response: " + stringResponse);
		JSONObject jsonObject = new JSONObject(stringResponse);
		JSONObject ratesObject = jsonObject.getJSONObject("rates");
		BigDecimal rate = ratesObject.getBigDecimal(toCurrency.toUpperCase());
		Double result =(double) Math.round(rate.multiply(quantity).doubleValue());
		System.out.println(result);
//		PrintWriter printWriter = response.getWriter();
		HttpSession session = request.getSession();
		session.setAttribute("convertedAmount", result.toString());
		RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
		dispatcher.forward(request, response);
//		printWriter.println("<p>converted amount"+result+"</p>");
	}

}
