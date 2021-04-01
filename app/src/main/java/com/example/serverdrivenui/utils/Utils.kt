package com.example.serverdrivenui.utils

import android.content.Context

object Utils {

    fun getUIJson(context: Context): String {

        return "{\n" +
                "     \"components\" : [\n" +
                "         {\n" +
                "             \"viewType\" : \"Banner\",\n" +
                "             \"text\" : \"Diwali Sale\"\n" +
                "         },\n" +
                "         {\n" +
                "             \"viewType\" : \"list_horizontal\",\n" +
                "             \"data\" : [\n" +
                "                 {\n" +
                "                     \"viewType\" : \"list_item\",\n" +
                "                     \"text\" : \"Flat 50% OFF\"\n" +
                "                 },\n" +
                "                 {\n" +
                "                     \"viewType\" : \"list_item\",\n" +
                "                     \"text\" : \"Flat 70% OFF\"\n" +
                "                 }, \n" +
                "                 {\n" +
                "                     \"viewType\" : \"list_item\",\n" +
                "                     \"text\" : \"Flat 80% OFF\"\n" +
                "                 },\n" +
                "                 {\n" +
                "                     \"viewType\" : \"list_item\",\n" +
                "                     \"text\" : \"Flat 70% OFF\"\n" +
                "                 }, \n" +
                "                 {\n" +
                "                     \"viewType\" : \"list_item\",\n" +
                "                     \"text\" : \"Flat 80% OFF\"\n" +
                "                 }\n" +
                "             ]\n" +
                "         },\n" +
                "         {\n" +
                "             \"viewType\" : \"Banner\",\n" +
                "             \"text\" : \"Deal of the day\"\n" +
                "         },\n" +
                "         {\n" +
                "             \"viewType\" : \"list_grid\",\n" +
                "             \"data\" : [\n" +
                "                 {\n" +
                "                     \"viewType\" : \"list_item\",\n" +
                "                     \"text\" : \"Under 399\"\n" +
                "                 },\n" +
                "                 {\n" +
                "                     \"viewType\" : \"list_item\",\n" +
                "                     \"text\" : \"under 499\"\n" +
                "                 }, \n" +
                "                 {\n" +
                "                     \"viewType\" : \"list_item\",\n" +
                "                     \"text\" : \"Under 999\"\n" +
                "                 },\n" +
                "                 {\n" +
                "                     \"viewType\" : \"list_item\",\n" +
                "                     \"text\" : \"Under 1399\"\n" +
                "                 }, \n" +
                "                 {\n" +
                "                     \"viewType\" : \"list_item\",\n" +
                "                     \"text\" : \"Under 1999\"\n" +
                "                 }\n" +
                "             ]\n" +
                "         }\n" +
                "         \n" +
                "     ]\n" +
                " }"

    }

}