find image -type f -name "*.dot" -exec sh -c 'dot -Tpng "${0}" -o "${0%.*}.png"' {} \;

