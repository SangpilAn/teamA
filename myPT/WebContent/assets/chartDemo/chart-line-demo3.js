// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

var ctx = document.getElementById("fatMass");

var myLineChart = new Chart(ctx, {
  type: 'line',
  data: {
    labels: ["측정일1", "측정일2", "측정일3", "측정일4", "측정일5", "측정일6"],
    datasets: [{
      label: "체지방량(kg)",
      lineTension: 0.5,
      backgroundColor: "rgba(255,255,255,0)",
      borderColor: "rgba(150,80,110,1)",
      pointRadius: 5,
      pointBackgroundColor: "rgba(120,80,110,1)",
      pointBorderColor: "rgba(255,255,255,0.8)",
      pointHoverBackgroundColor: "rgba(2,117,216,1)",
      data: [20, 19, 18, 16, 14, 13],
    }],
  },
  options: {
    scales: {
      xAxes: [{
        time: {
          unit: 'date'
        },
        gridLines: {
          display: true,          
          color: "rgba(0, 0, 0, .15)",
        },
        ticks: {
          maxTicksLimit: 7
        }
      }],
    //   가져오는 데이터 값에 따라 유연하게
      yAxes: [{
        ticks: {
          min: 10,
          max: 20,
          stepSize: 1,
          maxTicksLimit: 10
        },
        gridLines: {
          color: "rgba(0, 0, 0, .2)",
        }
      }],
    },
    scaleShowLabelBackdrop : true,
    showAllTooltips : true,
    tooltips: {
        displayColors: false,
        callbacks:{
                    label: function(tooltipItem, data) {                  
                    return data['datasets'][0]['data'][tooltipItem['index']];
                    }
             }
   },
    legend: {
      display: false
    }
  }
});
