#!/bin/zsh

if [ -e "test" ];then
  rm -rf ./test
fi

contest=$1
type=$2
upper_type=${type:u}
param=$3
src_dir=./src/main/kotlin/
oj d https://atcoder.jp/contests/$contest/tasks/${contest}_${type}

kotlinc ${src_dir}${upper_type}.kt
mv ${upper_type}Kt.class ./class/

#oj t -e 1e-6 -c "kotlin -classpath ./class ${upper_type}Kt" | grep "FAILURE"
oj t -c "kotlin -classpath ./class ${upper_type}Kt" | grep "FAILURE"

if [ $? = 0 ];then
  echo "テストエラー"
  return
else
  echo "テスト成功"
fi

if [ -n "$param" ] && [ $param = "test" ];then
  return
fi

oj s https://atcoder.jp/contests/${contest}/tasks/${contest}_${type} ${src_dir}${upper_type}.kt