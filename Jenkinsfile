pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        sh 'mvn clean package -DskipTests '
      }
    }

    stage('test') {
      steps {
        sh ' mvn clean test '
      }
    }

    stage('sonar scan') {
      steps {
        sh ' echo \'sonar scan code\' '
      }
    }

    stage('deploy') {
      steps {
        sh ''' 
                
                app=jenkins-springboot-1.0.0
                #项目移动的目的地址
                path=/root/projects
                echo this is app : $app
                #项目已启动,杀死旧进程
                api_pid=`ps -ef | grep "$app.jar" | grep -v grep | awk \'{print $2}\'`
                echo api_pid = $api_pid
                if [ "$api_pid" != "" ]; then
                echo kill api
                kill -9 $api_pid
                echo sleep 3s
                sleep 1
                echo sleep 2s
                sleep 1
                echo sleep Is
                sleep 1
                fi
                # 籽诂「包从jenkinsj：作空间中移动到指定路径下
                cp /var/lib/jenkins/workspace/jenkins-springboot/target/$app.jar $path
                cd $path
                #防止进程被杀死
                BUILD_ID=dontKillMe
                #后台进程形式启动项目,日志文件为out log
                nohup java -jar $app.jar --server.port=8085 >> out.log 2>&1 &
                echo $app start success
                
                '''
      }
    }

  }
  environment {
    mvn = '/usr/local/softwares/maven/bin/mvn'
    java = '/usr/bin/java'
  }
}