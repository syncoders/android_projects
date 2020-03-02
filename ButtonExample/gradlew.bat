import 'dart:convert';

import 'package:connectivity/connectivity.dart';
import 'package:flutter/material.dart';
import 'package:salezz/UI/Visit/Model/RescheduleModel.dart';
import 'package:salezz/UI/Visit/Model/VisitModel.dart';
import 'package:salezz/UI/Visit/VisitRow.dart';
import 'package:salezz/commonComponents/MyNavigator.dart';
import 'package:http/http.dart' as http;
import 'package:salezz/commonComponents/genaralHelper.dart';
import 'package:shared_preferences/shared_preferences.dart';

import '../../Const.dart';
import 'RescheduleRow.dart';

// ignore: must_be_immutable
class MyVisit extends StatefulWidget {
  @override
  _MyVisitState createState() => new _MyVisitState();
}

class _MyVisitState extends State<MyVisit> {
  final GlobalKey<ScaffoldState> _scaffoldKey = new GlobalKey<ScaffoldState>();
  List<Visits> _myVisits = [];
  List<RescheduleDetails> _upcomingVisits = [];
  String u_id;
  SharedPreferences sharedPreferences;
  GeneralHelper generalHelper = new GeneralHelper();

  //for search
  TextEditingController editingController = TextEditingController();

   List<Visits>duplicateItems;
  var items = List<Visits>();

  @override
  initState() {
    super.initState();
    getData();
//    noAuthPostMethodForVisits("http://salez.cryptappz.com/api/salesman/business_approach_visit/2");
  }

  @override
  Widget build(BuildContext context) {
    return
      DefaultTabController(
          length: 2,
          child: Scaffold(
            backgroundColor: Colors.white,
            appBar: TabBar(
              indicatorColor: Colors.redAccent,
                labelColor: Colors.white,
                unselectedLabelColor: Colors.redAccent,
                indicatorSize: TabBarIndicatorSize.label,
                indicator: BoxDecoration(
                    borderRadius: BorderRadius.only(
                        topLeft: Radius.circular(10),
                        topRight: Radius.circular(10),
                    bottomLeft: Radius.circular(10),
                bottomRight:  Radius.circular(10)),
                    color: Colors.redAccent),
                tabs: [
                  Tab(
                    child: Align(
                    