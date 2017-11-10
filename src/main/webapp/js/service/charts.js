/**
 * Created by leiguorui on 2017/11/8.
 */


// 基于准备好的dom，初始化echarts实例
var myEChart = echarts.init(document.getElementById('echarts'));

$.get('/order/list.json').done(function (data) {

    var seriesArray = [];
    var legendData = [];

    $.each( data.userdata, function( key, value ) {

        var legendName = value.currency + "[ " + value.tradingId + " ]";

        var series = {
            name: legendName,
            symbol: 'none',
            type: 'line',
            data: []
        };

        legendData.push(legendName);

        $.each(value.tradingPrices, function( keyPrice, valuePrice ) {
            series.data.push([keyPrice, valuePrice.profitPrice]);
        });

        seriesArray.push(series);

    });

    var chartOption = {
        legend: {
            data:legendData
        },
        xAxis: { },
        yAxis: { },
        dataZoom: [
            {
                type: 'inside',
                xAxisIndex: 0,
                filterMode: 'empty'
            }
        ],
        series: seriesArray
    };

    myEChart.setOption(chartOption);

    myEChart.on('dataZoom', function () {

    });

});




