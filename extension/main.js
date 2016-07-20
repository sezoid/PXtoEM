chrome.app.runtime.onLaunched.addListener(function() {
  var screenWidth = screen.availWidth;
  var screenHeight = screen.availHeight;
  var width = 290;
  var height = 353;

  chrome.app.window.create('index.html', {
    id: "PXtoEM",
    innerBounds: {
      width: width,
      height: height,
      left: Math.round((screenWidth-width)/2),
      top: Math.round((screenHeight-height)/2)
    },
    frame: {
      type: "none"
    },
    resizable: false
  });
});