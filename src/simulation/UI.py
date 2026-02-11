import curses

GRID_ROWS = 30
GRID_COLS = 40

EMPTY = "."
TRUCK = "T"
PERSON = "P"

people = []
trucks = []

def make_grid():
    grid = []
    for i in range(GRID_ROWS):
        row = [EMPTY] * GRID_COLS
        grid.append(row)
    return grid


def add_person(grid, name, row, col):
    if 0 <= row < GRID_ROWS and 0 <= col < GRID_COLS:
        if grid[row][col] == EMPTY:
            grid[row][col] = PERSON
            people.append({"name": name, "row": row, "col": col})
            return True
    return False


def move_person(grid, stdscr, name, target_row, target_col, speed_ms=200):
    for person in people:
        if person["name"] == name:
            break
    else:
        return False

    current_row, current_col = person["row"], person["col"]
    
    while (current_row, current_col) != (target_row, target_col):
        grid[current_row][current_col] = EMPTY
        
        # Move one step
        if current_row < target_row: current_row += 1
        elif current_row > target_row: current_row -= 1
        elif current_col < target_col: current_col += 1
        elif current_col > target_col: current_col -= 1
        
        person["row"], person["col"] = current_row, current_col
        
        if grid[current_row][current_col] == EMPTY:
            grid[current_row][current_col] = PERSON
        
        stdscr.refresh()
        curses.napms(speed_ms)
    
    return True




def add_truck(grid, name, row, col, length, width):
    """Place a food truck on the grid with center at (row, col)."""
    start_row = row - (width // 2)
    end_row = row + (width // 2) + (width % 2)
    start_col = col - (length // 2)
    end_col = col + (length // 2) + (length % 2)
    
    for r in range(start_row, end_row):
        for c in range(start_col, end_col):
            if 0 <= r < GRID_ROWS and 0 <= c < GRID_COLS:
                grid[r][c] = TRUCK
    
    trucks.append({
        "name": name, 
        "center_row": row, 
        "center_col": col,
        "length": length,
        "width": width
    })



def draw(stdscr, grid):
    curses.start_color()
    curses.use_default_colors()
    curses.init_pair(1, curses.COLOR_GREEN, -1)   # empty
    curses.init_pair(2, curses.COLOR_YELLOW, -1)  # truck
    curses.init_pair(3, curses.COLOR_CYAN, -1)    # UI
    curses.init_pair(4, curses.COLOR_RED, -1)     # PERSON - RED!

    stdscr.erase()
    rows, cols = stdscr.getmaxyx()

    title = f"Food Truck Grid ({GRID_ROWS}x{GRID_COLS})"
    try:
        stdscr.addstr(0, 0, title[:cols-1], curses.color_pair(3) | curses.A_BOLD)
    except curses.error:
        pass

    # Draw entire grid
    for gr in range(GRID_ROWS):
        for gc in range(GRID_COLS):
            screen_row = gr + 2
            screen_col = gc * 2
            
            if screen_row >= rows - 1 or screen_col >= cols:
                continue
                
            cell = grid[gr][gc]
            if cell == TRUCK:
                attr = curses.color_pair(2) | curses.A_BOLD
            elif cell == PERSON:
                attr = curses.color_pair(4) | curses.A_BOLD  # RED PERSON!
            else:
                attr = curses.color_pair(1) | curses.A_DIM
            try:
                stdscr.addstr(screen_row, screen_col, cell, attr)
            except curses.error:
                pass

    legend_x = GRID_COLS * 2 + 2
    try:
        stdscr.addstr(2, legend_x, "TRUCKS", curses.color_pair(3) | curses.A_BOLD)
        stdscr.addstr(3, legend_x, "─" * 20, curses.color_pair(3))
        for i, t in enumerate(trucks[:10]):
            line = f"{t['name'][:12]} ({t['center_row']},{t['center_col']}) {t['length']}x{t['width']}"
            stdscr.addstr(4 + i, legend_x, line[:25], curses.color_pair(2))
        
        stdscr.addstr(15, legend_x, "PEOPLE", curses.color_pair(3) | curses.A_BOLD)
        stdscr.addstr(16, legend_x, "─" * 20, curses.color_pair(3))
        for i, p in enumerate(people[:8]):
            line = f"{p['name']} ({p['row']},{p['col']})"
            stdscr.addstr(17 + i, legend_x, line[:25], curses.color_pair(4))
    except curses.error:
        pass

    hint = " Q: quit "
    try:
        stdscr.addstr(rows - 1, 0, hint[:cols-1], curses.color_pair(3))
    except curses.error:
        pass

    stdscr.refresh()

def main(stdscr):
    curses.curs_set(0)
    stdscr.timeout(50)

    grid = make_grid()
    
    # add_truck(grid, "Taco Loco", 10, 10, 2, 3)
    # add_truck(grid, "Burger Barn", 10, 20, 2, 5)
    # add_truck(grid, "Wok & Roll", 25, 35, 1, 3)
    
    # add_person(grid, "Alice", 5, 5)
    # add_person(grid, "Bob", 5, 15)
    
    while True:
        draw(stdscr, grid)
        key = stdscr.getch()

        #GAME
        if key in (ord('q'), ord('Q')):
            break
        if key in (ord('s'), ord('S')):
            startSim()


def startSim():
    print("FUN!")


if __name__ == "__main__":
    curses.wrapper(main)
