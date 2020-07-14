import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';
import 'package:flutter_boost/flutter_boost.dart';

class FirstRouteWidget extends StatefulWidget {
  @override
  _FirstRouteWidgetState createState() => _FirstRouteWidgetState();
}

class _FirstRouteWidgetState extends State<FirstRouteWidget> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('First Route'),
      ),
      body: Center(
        child: RaisedButton(
          child: Text('open amap widget'),
          onPressed: () {
//            print("open second page!");
            FlutterBoost.singleton.open("flutterbus://flutternativePage",
                urlParams: {"test": "flutter to flutter "}).then((Map value) {
              print(
                  "call me when page is finished. did recieve second route result $value");
            });
//            BoostContainerSettings settings = BoostContainer.of(context).settings;
//            FlutterBoost.singleton.close(settings.uniqueId, result: {"result": "data from second"});
          },
        ),
      ),
    );
  }
}
