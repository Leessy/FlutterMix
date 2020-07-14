import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';
import 'package:flutter_boost/flutter_boost.dart';

class ViewWidget extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Hi,I am is title."),
      ),
      body: Center(
        child: RaisedButton(
          onPressed: () {
            // Navigate back to first route when tapped.
//            BoostContainerSettings settings =
//                BoostContainer.of(context).settings;
//            FlutterBoost.singleton.close(settings.uniqueId,
//                result: {"result": "data from second"});
          },
          child: Text('flutter widget content!'),
        ),
      ),
    );
  }
}
