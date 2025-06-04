① 사용자 인증 기능

1) 회원가입, 로그인 기능 구현 (이메일/비밀번호)
2) Spring Security 기반 로그인 및 로그아웃 기능 적용
3) BCryptPasswordEncoder 사용하여 비밀번호를 안전하게 저장

② 권한(Role) 기반 인가 기능
1) 기본 권한: ROLE_USER, ROLE_ADMIN
2) 권한별 기능 제한:
o ROLE_USER: 상품 목록 조회만 가능 (GET /products)
o ROLE_ADMIN: 상품 등록, 수정, 삭제 가능 (POST, PUT, DELETE)
3) UI 요소도 권한에 따라 제어 (예: 일반 사용자는 Edit/Delete 버튼 비활성화)

③ 추가 기능
1) 로그인 성공/실패시 사용자 맞춤 메시지 출력
2) 상품 등록/수정 시 유효성 검사 (예: 가격은 0 이상이어야 함)
3) ROLE_ADMIN 사용자만 접근 가능한 관리자 페이지 구현
A. 전체 사용자 목록 확인
