import re

def non_latin_to_unicode(input_file_path, output_file_path):
    with open(input_file_path, 'r', encoding='utf-8') as input_file:
        input_text = input_file.read()
    unicode_text = re.sub(r'[^\x00-\x7F]', lambda m: '\\u{:04x}'.format(ord(m.group(0))), input_text)
    with open(output_file_path, 'w', encoding='utf-8') as output_file:
        output_file.write(unicode_text)

if __name__ == '__main__':
    non_latin_to_unicode('input.txt', 'output.txt')

