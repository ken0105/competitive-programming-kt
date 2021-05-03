#!/bin/zsh

if [ -e "test" ];then
  rm -rf ./test
fi

contest=$1
type=$2
upper_type=${type:u}
point=$3
src_dir=./src/main/kotlin/
archive_name=Test.jar
oj d https://atcoder.jp/contests/$contest/tasks/${contest}_${type}

kotlinc ${src_dir}${upper_type}.kt -include-runtime -d ${archive_name}
mv ${archive_name} ./jar/

if [ -z "$point" ]; then
  oj t -c "kotlin ./jar/${archive_name}" | grep "FAILURE"
else
  oj t -e 1e-${point} -c "kotlin ./jar/${archive_name}" | grep "FAILURE"
fi

if [ $? = 0 ];then
  echo "テストエラー"
  return
else
  echo "テスト成功"
fi

oj s --yes https://atcoder.jp/contests/${contest}/tasks/${contest}_${type} ${src_dir}${upper_type}.kt