/**
 * Created by leiguorui on 2017/11/8.
 */


// 基于准备好的dom，初始化echarts实例
var myEChart = echarts.init(document.getElementById('echarts'));

$.get('/order/list.json').done(function (data) {

    var seriesArray = [];
    var egendData = [];

    $.each( data.userdata, function( key, value ) {

        var egendName = value.currency + "[ " + value.tradingId + " ]";

        var series = {
            name: egendName,
            symbol: 'none',
            type: 'line',
            data: []
        };

        egendData.push(egendName);

        $.each(value.tradingPrices, function( keyPrice, valuePrice ) {
            series.data.push([keyPrice, valuePrice.profitPrice]);
        });

        seriesArray.push(series);

    });

    var chartOption = {
        egend: {
            data:egendData
        },
        xAxis: { },
        yAxis: { },
        dataZoom: [
            {
                type: 'inside',
                xAxisIndex: 0,
                filterMode: 'empty'
            },
            {
                type: 'inside',
                yAxisIndex: 0,
                filterMode: 'empty'
            }
        ],
        series: seriesArray
    };

    myEChart.setOption(chartOption);

    myEChart.on('dataZoom', function () {

    });

});




