<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>메인 페이지</title>
    <link href="/myPT/css/styles.css" rel="stylesheet" />
    <link href="/myPT/css/index.css" rel="stylesheet"/>
    <link href="/myPT/css/widget.css" rel="stylesheet"/>

    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"
    ></script>

  </head>
  <body class="sb-nav-fixed">
    <!-- nav -->
    <jsp:include page="/includeFiles/nav.jsp"></jsp:include>
    <!-- nav -->

    <!-- QR 모달 -->
    <jsp:include page="/includeFiles/modalQR.jsp"></jsp:include>
    <!--//QR 모달-->

    <div id="layoutSidenav">
      <!-- sideNav -->
      <jsp:include page="/includeFiles/userSideNav.jsp"></jsp:include>
      <!-- /sideNav -->
      <div id="layoutSidenav_content">
        <main>
          <div class="container-fluid">
          	<h1 class="mt-4 mb-4">메인 페이지</h1>
            <div class="card-group text-center p-0" id="weekSchedule">
              <div class="card mb-4 p-0" id="week1">
                <div class="card-header bg-dark text-white">월요일</div>
                <div class="card-body">
                  <div class="card"id="btnMon"
                  		data-toggle="modal">
                  </div>
                </div>
              </div>
              <div class="card mb-4 p-0" id="week2">
                <div class="card-header bg-dark text-white">화요일</div>
                <div class="card-body">
                  <div class="card" id="btnTue"
                  		data-toggle="modal">
                  </div>
                </div>
              </div>
              <div class="card mb-4 p-0" id="week3">
                <div class="card-header bg-dark text-white">수요일</div>
                <div class="card-body">
                  <div class="card" id="btnWed"
                  data-toggle="modal">
                  </div>
                </div>
              </div>
              <div class="card mb-4 p-0" id="week4">
                <div class="card-header bg-dark text-white">목요일</div>
                <div class="card-body">
                  <div class="card" id="btnThu"
                  	data-toggle="modal">
                  </div>
                </div>
              </div>
              <div class="card mb-4 p-0" id="week5">
                <div class="card-header bg-dark text-white">금요일</div>
                <div class="card-body">
                  <div class="card" id="btnFri"
                  data-toggle="modal">
                  </div>
                </div>
              </div>

            </div>
            <div class="card mb-4">
              <div class="card-header bg-dark text-white">
                <i class="fas fa-chart-area mr-1"></i>
                Personal Trainning
              </div>
              <div class="card-body">
                <ul class="list-group">
                  <li class="list-group-item">
                    <div class="widget-content p-0">
                      <div class="widget-content-wrapper">
                        <div class="widget-content-left">
                          <div class="widget-heading">남은 횟수</div>
                          <div class="widget-subheading"></div>
                        </div>
                        <div class="widget-content-right">
                          <div
                            class="widget-numbers"
                            style="color: #3ac47d !important"
                          >
                            ${ptcount}
                          </div>
                        </div>
                      </div>
                    </div>
                  </li>
                  <li class="list-group-item">
                    <div class="widget-content p-0">
                      <div class="widget-content-wrapper">
                        <div class="widget-content-left">
                          <div class="widget-heading">담당 트레이너</div>
                          <div class="widget-subheading">${t_nick }</div>
                        </div>
                        <div class="widget-content-right">
                          <div class="widget-numbers text-primary">${t_name }</div>
                        </div>
                      </div>
                    </div>
                  </li>
                  <li class="list-group-item">
                    <div class="widget-content p-0">
                      <div class="widget-content-wrapper">
                        <div class="widget-content-left">
                          <div class="widget-heading">시작일자</div>
                          <div class="widget-subheading"></div>
                        </div>
                        <div class="widget-content-right">
                          <div class="widget-numbers text-warning">
                            ${startdate }
                          </div>
                        </div>
                      </div>
                    </div>
                  </li>
                  <li class="list-group-item">
                    <div class="widget-content p-0">
                      <div class="widget-content-wrapper">
                        <div class="widget-content-left">
                          <div class="widget-heading">종료일자</div>
                          <div class="widget-subheading"></div>
                        </div>
                        <div class="widget-content-right">
                          <div class="widget-numbers text-dark">${enddate }</div>
                        </div>
                      </div>
                    </div>
                  </li>
                  <li class="list-group-item">
                    <div class="widget-content p-0">
                      <div class="widget-content-wrapper">
                        <div class="widget-content-left">
                          <div class="widget-heading">조절 체중</div>
                          <div class="widget-subheading">조절</div>
                        </div>
                        <div class="widget-content-right">
                          <div class="widget-numbers text-danger">-10KG</div>
                        </div>
                      </div>
                    </div>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </main>
      </div>
      
      <!-- 모달 -->
      <jsp:include page="/includeFiles/modalUserMain.jsp"></jsp:include>
      <!-- /모달 -->
    </div>
    <script
      src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script
      src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js">
    </script>
    <script src="/myPT/js/scripts.js"></script>
    <script src="/myPT/js/userAttendance.js"></script>
    <script src="/myPT/js/userMain.js"></script>
  </body>
</html>
