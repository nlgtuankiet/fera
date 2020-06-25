#!/bin/bash
set -e

# $1 flavor
# $2 build type
# $3 grant all permission
# ${@:4} path to project contain apk

installCmd="install-multiple -r"

if [[ "$3" = "true" ]]; then
  installCmd="$installCmd -g"
fi

if [[ "$1" = "dev" ]]; then
  installCmd="$installCmd com.nlgtuankiet.fera"
else
  installCmd="$installCmd com.nlgtuankiet.fera"
fi

for i in "${@:4}"; do
  installCmd="$installCmd $(find "${i}"/build/outputs -path "*/$2/*.apk" | sed "s/\n/ /g")"
done

echo "$installCmd"

for d in $(adb devices | grep -v List | cut -f 1);
do
  echo "Install on device $d"
  adb -s $d $installCmd
done