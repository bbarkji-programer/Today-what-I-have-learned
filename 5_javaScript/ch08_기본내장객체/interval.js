// interval.js (Date 객체에 추가한 - 두 시점 날짜 계산하는 getInterval 함수)
// JavaScript source code
Date.prototype.getInterval = function (otherDay) { // Date 내장객체에 함수를 추가
    if (this > otherDay) { // today는 interval 함수의 객체니까 this=today
        var intervalMilli = this.getTime() - otherDay.getTime();
    } else {
        var intervalMilli = otherDay.getTime() - this.getTime();
    }
    var intervalDay = Math.floor(intervalMilli / (1000 * 60 * 60 * 24)); // javaScript는 변수가 function 단위라 가능
    return intervalDay;
}; 