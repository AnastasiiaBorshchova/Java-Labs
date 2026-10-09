#!/usr/bin/env bash
# Використання:  bash setup_github.sh https://github.com/<логін>/<репозиторій>.git
# 1) Створіть на github.com ПУСТИЙ публічний репозиторій (без README/.gitignore).
# 2) Запустіть цей скрипт у папці Java-Labs (у Windows - через Git Bash).
set -e
REMOTE="$1"
[ -z "$REMOTE" ] && { echo "Вкажіть URL репозиторію"; exit 1; }

# забираємо папки лабораторних зі стартового стану
mkdir -p /tmp/labs_stash && rm -rf /tmp/labs_stash/* 
for d in LR_0 LR_1 LR_2 LR_3 LR_4; do mv "$d" /tmp/labs_stash/; done

git init -b master
git add README.md .gitignore setup_github.sh
git commit -m "Initial commit: README"
git remote add origin "$REMOTE"

for n in 0 1 2 3 4; do
  git checkout -b LR_$n master
  mv /tmp/labs_stash/LR_$n .
  git add LR_$n
  git commit -m "LR_$n: лабораторна робота $n"
  git checkout master
  git merge --no-ff LR_$n -m "Merge LR_$n into master"
done

git push -u origin master
git push origin LR_0 LR_1 LR_2 LR_3 LR_4
echo "Готово. Переконайтесь, що репозиторій Public."
