import 'package:camera/camera.dart';
import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';
import 'package:flutter_module/page/VideoPlayerApp.dart';
import 'SignaturePainter.dart';
import 'TakePictureScreen.dart';

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
        child: Column(
          children: <Widget>[
            RaisedButton(
              child: Text('启动相机拍照'),
              onPressed: () async {
                WidgetsFlutterBinding.ensureInitialized();
                // Obtain a list of the available cameras on the device.
                final cameras = await availableCameras();
                debugPrint("相机个数11？" + cameras.length.toString());

                // Get a specific camera from the list of available cameras.
                final firstCamera = cameras.first;
//              FlutterBoost.singleton.open("ImagePickerWidget",
//                  urlParams: {"test": "flutter to flutter "});
                Navigator.push(
                  context,
                  MaterialPageRoute(
                    builder: (context) => TakePictureScreen(
                      // Pass the appropriate camera to the TakePictureScreen widget.
                      camera: firstCamera,
                    ),
                  ),
                );
//            BoostContainerSettings settings = BoostContainer.of(context).settings;
//            FlutterBoost.singleton.close(settings.uniqueId, result: {"result": "data from second"});
              },
            ),
            RaisedButton(
              child: Text('启动视频播放demo'),
              onPressed: () async {
                Navigator.push(
                  context,
                  MaterialPageRoute(
                    builder: (context) => VideoPlayerScreen(),
                  ),
                );
//            BoostContainerSettings settings = BoostContainer.of(context).settings;
//            FlutterBoost.singleton.close(settings.uniqueId, result: {"result": "data from second"});
              },
            ),
            RaisedButton(
              child: Text('画板'),
              onPressed: () async {
                Navigator.push(
                  context,
                  MaterialPageRoute(
                    builder: (context) => Signature(),
                  ),
                );
//            BoostContainerSettings settings = BoostContainer.of(context).settings;
//            FlutterBoost.singleton.close(settings.uniqueId, result: {"result": "data from second"});
              },
            ),
          ],
        ),
      ),
    );
  }
}
