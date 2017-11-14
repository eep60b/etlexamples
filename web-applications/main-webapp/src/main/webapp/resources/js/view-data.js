//Using this JavaScript, the page will be reloaded at a given time (10 minutes for default).

var idleTime = 0;

$(document).ready(function () {
  
  //Increment the idle time counter every second (1000 milisecond).
  setInterval(timerIncrement, 1000);
});

function timerIncrement() {
  idleTime = idleTime + 1;

  //Reload the page if idle time is longer than 10 minutes (600 seconds).
  //This time need to be the same as the session-timeout in web.xml.
  if (idleTime > 600) {
    window.location.reload();
  }
}

function resetTimer() {
  idleTime = 0;
}
//Using this JavaScript, the page will be reloaded at a given time (10 minutes for default).

var idleTime = 0;

$(document).ready(function () {
  
  //Increment the idle time counter every second (1000 milisecond).
  setInterval(timerIncrement, 1000);
});

function timerIncrement() {
  idleTime = idleTime + 1;

  //Reload the page if idle time is longer than 10 minutes (600 seconds).
  //This time need to be the same as the session-timeout in web.xml.
  if (idleTime > 600) {
    window.location.reload();
  }
}

function resetTimer() {
  idleTime = 0;
}