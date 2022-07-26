-- ex28_oracle_cloud.sql

/*

    오라클 클라우드 서비스
    - Oracle Cloud Free Tier
    - VM(Virtual Machine) > 가상 컴퓨터 > 나중에 웹 수업 > 프로젝트 운영 or 포트폴리오(웹)
    
    - 무료 서비스 > 1인 사용 적당
    - 프로젝트 > N인 사용 부족..
    
    
    가상 서버
    - 운영체제 > Ubuntu 20.04 LTS
    - 접속 계정 > "ubuntu" + ""
    
    
    
    pwd
    - Print working directory
    - 현재 작업 중 폴더의 경로
    ex) /home/ubuntu/ > ubuntu 계정의 홈 디렉토리
    
    
    ls <옵션> <디렉토리>
    - List Directory Contents
    - '-a' : all > 모든 파일과 디렉토리를 다 출력해라.(숨긴 파일/숨긴 디렉토리)
    - '-l' : long > 정보를 상세하게...
    ex) ls -a -l
    ex) ls -al
    ex) ls -la
    
    
    clear
    - Clear Screen
    
    
    방향키(위, 아래)
    - 현재까지 실행했던 명령어의 이력 탐색
    
    Tap키
    - 자동완성 기능
    
    
    man <명령어>
    - User's Manual
    
    
    cd
    - Change Directory
    ex) cd ..
    ex) cd 자식디렉토리
    ex) cd / > 최상위 디렉토리로 이동
    ex) cd ~ > 홈 디렉토리로 이동
    ex) cd - > 이전 디렉토리로 이동
    ex) cd > 홈 디렉토리로 이동
    
    
    Prompt
    > 계정이름@서버이름:현재디렉토리$
    
    홈 디렉토리
    > ubuntu@ubuntu:~$
    
    
    
    
    free
    - 현재 시스템이 사용중인 메모리를 보여준다.
    
    
    date
    - 시스템의 현재 시간을 보여준다. 
    
    
    
    
    -------------------------------------------------------------------------------------------------
    
    mkdir
    - make directory
    - $ mkdir 폴더명 > 폴더 생성
    - $ mkdir 폴더명 폴더명 폴더명 > 한번에 여러개 폴더 생성
    - $ mkdir -p 폴더명 폴더명 폴더명 > 부모의 폴더까지 생성
    
    rmdir
    - remove directory
    - $ rmdir 폴더명 > 폴더 삭제
    - $ rmdir 폴더명/폴더명/폴더명 > 가장 끝 폴더 삭제
    - $ rmdir -p 폴더명/폴더명/폴더명 > 모든 폴더를 삭제한다.
    
    
    touch
    - $ touch 파일명
    - 파일을 생성한다.
    
    vim
    - $ vim 파일명
    - 파일 내용을 수정한다.
    
    - i / a > INSERT 모드
    - esc :wq > 저장하고 종료
    - esc :q > 종료
    - esc :q! > 강제종료
    
    
    tree > 트리구조로 보여준다
    - 기본 명령어가 아니다. > 설치를 하면 된다.
    - $ sudo apt-get install tree
    
    
    -------------------------------------------------------------------------------------------------
    
    
    쉘
    - echo $0 --> 현재 사용중인 쉘을 나타낸다.
    1. bash
    2. zsh
    
    
    zsh 설치
    - $ sudo apt-get install zsh
    - $ sudo chsh -s $(which zsh) // 기본 쉘을 zsh로 변경한다.
    - $ sudo chsh -s /usr/bin/zsh // 기본 쉘을 zsh로 변경한다.
    
    zsh 확장 테마
    - oh-my-zsh > 제공 플러그인 중 테마
    - $ sh -c "$(wget -O- https://raw.githubusercontent.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"
    
    
    Swap
    - 메모리의 부족을 보완하기 위해서 > 하드 디스크의 일부를 메모리처럼 사용하게 해준다.
    
    1. $ sudo fallocate -l 4G /swapfile
    2. $ sudo chmod 600 /swapfile
    3. $ sudo mkswap /swapfile
    4. $ sudo swapon /swapfile
    5. $ free
    6. 위의 설정을 서버 재시작할때도 유지
        - /etc/fstab 파일
        
        
    파일 열기 > 보기 or 편집
    1. cat <파일>
        - 파일의 내용을 보여준다.
        - 읽기
        - $ cat /etc/fstab
        
    2. vi, vim, nano
    
    
    루트 사용자 > root > 모든 권한을 가진 관리자
    현재 로그인 계정 > ubuntu > 일반 사용자
    
    
    현재 시각 설정하기
    1. $ sudo dpkg-reconfigure tzdata
    2. Asia
    3. Seoul
    4. date
    
    -----------------------------------------------------------------------------------
    
    
    리눅스에서 패키지(프로그램) 설치하기
     - apt
     - apt-get
     
     1. $ sudo apt-get update //현재 시스템의 패키지 상태를 최신 버전으로 업데이트
     2. $ sudo apt-get install nginx
     
     3. $ sudo systemctl status nginx //현재 패키지의 상태를 보여준다. > active(running)
     4. $ sudo systemctl stop nginx //실행중인 패키지를 중단하다. > inactive(dead)
     5. $ sudo systemctl start nginx
     
     6. $ sudo systemctl enable nginx   //서버 시작시 같이 실행된다. (시작프로그램)
     7. $ sudo systemctl disable nginx  //자동 시작 중지
    
    
    오라클 클라우드에서 방화벽 열기
    우분투에서 방화벽 열기
    - $ sudo iptables -I INPUT 1 -p tcp --dport 80 -j ACCEPT
    - $ sudo iptables -I INPUT 1 -p tcp --dport 443 -j ACCEPT
    
    브라우저 주소창 > 144.24.82.11
    
    
    파일 호스트간에 전송 > FTP > SFTP
    
    Nginx 기본 홈 디렉토리 > /var/www/html
    
    
    권한 부여
    - $ sudo chmod -R 777 /var/www/html
    
    
    
    
    
    도메인 구조 == 카테고리 == 패키지
    
    하위.중위.상위
    
    test.com > 상업 도메인 (= 미국)
    test.co.kr > 국가(한국) 도메인
    test.co.jp > 일본 도메인
    test.ac.kr > ac > 대학 도메인
    test.go.kr > 정부 도메인
    test.org > 비영리 도메인
    
    최상위 도메인
    - 국가 도메인
    
    
    

*/



















