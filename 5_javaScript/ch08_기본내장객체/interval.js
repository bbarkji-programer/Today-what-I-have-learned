// interval.js (Date ��ü�� �߰��� - �� ���� ��¥ ����ϴ� getInterval �Լ�)
// JavaScript source code
Date.prototype.getInterval = function (otherDay) { // Date ���尴ü�� �Լ��� �߰�
    if (this > otherDay) { // today�� interval �Լ��� ��ü�ϱ� this=today
        var intervalMilli = this.getTime() - otherDay.getTime();
    } else {
        var intervalMilli = otherDay.getTime() - this.getTime();
    }
    var intervalDay = Math.floor(intervalMilli / (1000 * 60 * 60 * 24)); // javaScript�� ������ function ������ ����
    return intervalDay;
}; 