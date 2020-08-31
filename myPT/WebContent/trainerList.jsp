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
    <title>트레이너 관리</title>
    <link href="css/styles.css" rel="stylesheet" />
    <link href="css/index.css" rel="stylesheet"/>
    <link href="css/widget.css" rel="stylesheet"/>
	<!-- 데이터 테이블 css -->
	<link
      href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
      rel="stylesheet"
      crossorigin="anonymous"
    />
    <!-- /데이터 테이블 css -->
	
    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"
    ></script>

  </head>
  <body class="sb-nav-fixed">
    <!-- nav -->
    <jsp:include page="includeFiles/nav.jsp"></jsp:include>
    <!-- nav -->

    <!-- QR 모달 -->
    <jsp:include page="includeFiles/modalQR.jsp"></jsp:include>
    <!--//QR 모달-->

    <div id="layoutSidenav">
      <!-- sideNav -->
      <jsp:include page="includeFiles/adminSideNav.jsp"></jsp:include>
      <!-- /sideNav -->
      <div id="layoutSidenav_content">
        <main>
			<div class="container-fulid">
            	<div class="card mb-4">
              		<div class="card-header font-weight-bold">
               		 <i class="fas fa-table mr-1"></i>
                회원 관리
              </div>
              <div class="card-body">
                <div class="table-responsive">
                  <table
                    class="table table-bordered"
                    id="dataTable"
                    width="100%"
                    cellspacing="0"
                  >
                    <thead class="text-center">
                      <tr>
                        <th>TID</th>
                        <th>이름</th>
                        <th>성별</th>
                        <th>생년월일</th>
                        <th>전화번호</th>
                        <th>수정하기</th>
                      </tr>
                    </thead>
                    <tbody class="text-center">
                      <tr>
                        <td>T0001</td>
                        <td>안상필</td>
                        <td>남</td>
                        <td>940511</td>
                        <td>010-7474-4303</td>
                        <td>
                          <button class="btn btn-primary custom-btn">
                            <i class="fas fa-edit"></i>
                          </button>
                        </td>
                      </tr>
                      <tr>
                        <td>T0002</td>
                        <td>유관순</td>
                        <td>여</td>
                        <td>010101</td>
                        <td>010-7474-4303</td>
                        <td>
                          <button class="btn btn-primary custom-btn">
                            <i class="fas fa-edit"></i>
                          </button>
                        </td>
                      </tr>
                      <tr>
                        <td>T0003</td>
                        <td>김갑환</td>
                        <td>남</td>
                        <td>900101</td>
                        <td>010-7474-4303</td>
                        <td>
                          <button class="btn btn-primary custom-btn">
                            <i class="fas fa-edit"></i>
                          </button>
                        </td>
                      </tr>
                      <tr>
                        <td>T0004</td>
                        <td>장보고</td>
                        <td>남</td>
                        <td>850101</td>
                        <td>010-7474-4303</td>
                        <td>
                          <button class="btn btn-primary custom-btn">
                            <i class="fas fa-edit"></i>
                          </button>
                        </td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          	</div>
        </main>
      </div>
    </div>
    <script
      src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script
      src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js">
    </script>
    <script src="js/scripts.js"></script>
    
    <!-- 데이터 테이블 js -->
    <script src="js/dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>
    <script src="assets/demo/datatables-demo.js"></script>
    <!-- /데이터 테이블 js -->
    
  </body>
</html>
