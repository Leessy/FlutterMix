import 'package:flutter/material.dart';
import 'package:flutter_boost/flutter_boost.dart';
import 'package:flutter_module/page/FirstRouteWidget.dart';
import 'package:flutter_module/page/SecondRouteWidget.dart';
import 'package:flutter_module/page/TakePictureScreen.dart';
import 'package:flutter_module/page/ViewWidget.dart';

void main() => runApp(MyHomePage());

//class MyApp extends StatelessWidget {
//  @override
//  Widget build(BuildContext context) {
//    return MaterialApp(
//      title: 'FlutterMix',
//      theme: ThemeData(
//        primarySwatch: Colors.blue,
//      ),
//      home: MyHomePage(title: 'FlutterMix--1'),
//      builder: FlutterBoost.init(postPush: _onRoutePushed),
//    );
//  }
//
//  void _onRoutePushed(
//      String pageName, String uniqueId, Map params, Route route, Future _) {
//    debugPrint("pageName :${pageName}" + "   params :${params.toString()}");
//  }
//}

class MyHomePage extends StatefulWidget {
  MyHomePage({Key key, this.title}) : super(key: key);
  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  @override
  void initState() {
    super.initState();
    FlutterBoost.singleton.registerPageBuilders({
      //fisrt widget
      "flutterbus://flutter_FirstPage": (pageName, params, _) {
        debugPrint("params :${params.toString()}");
        return FirstRouteWidget();
      },
      //second widget
      'flutterbus://flutter_SecondPage': (pageName, params, _) {
        debugPrint("params :${params.toString()}");
        return SecondRouteWidget();
      },
      //ViewWidget
      'flutterbus://ViewWidget': (pageName, params, _) {
        debugPrint("params :${params.toString()}");
        return ViewWidget();
      },
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        title: 'Flutter Boost example',
        builder: FlutterBoost.init(postPush: _onRoutePushed),
        home: Container(color: Colors.white));
  }
  void _onRoutePushed(
      String pageName, String uniqueId, Map params, Route route, Future _) {
    debugPrint("pageName :${pageName}" + "   params :${params.toString()}");
  }
}
