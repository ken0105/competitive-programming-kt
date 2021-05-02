#!/bin/zsh

pushd ../competitive-programming-history
procon-gardener archive
git add .
today=`date '+%Y-%m-%d'`
echo $today
git commit -m $today
git push
popd